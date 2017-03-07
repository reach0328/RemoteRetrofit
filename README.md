#**RemoteRetrofit**

> 서울 공공데이터 주차장 위치 값과 주차공간을 가져와 보여주는 예제

##Retrofit
```
Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://openapi.seoul.go.kr:8088/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
```

##사용할 인터페이스 설정
```
SeoulOpenService service = retrofit.create(SeoulOpenService.class);
```

## Interface
```
public interface SeoulOpenService {
    // full address = http://openapi.seoul.go.kr:8088/774e574b4b72656133344272687368/json/SearchParkingInfo/1/1000"
    @GET("774e574b4b72656133344272687368/json/SearchParkingInfo/1/1000/{gu}") //레스풀 방식
    Call<Data> getData(@Path("gu") String value);
}

```
##데이터를 가져오는 부분
```
result.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                // 값이 정삭적으로 리턴 됐을 경우
                if(response.isSuccessful()) {
                    Data data = response.body(); // 원래 반환값인 jsonString 이 Data클래스로 변환되어 리턴된다.

                    for (Row row : data.getSearchParkingInfo().getRow()) {
                        LatLng parking = new LatLng(convertDouble(row.getLAT()),convertDouble(row.getLNG()));
                        double space = convertDouble(row.getCAPACITY());
                        Marker marker = mMap.addMarker(new MarkerOptions().position(parking).title(space+""));
                        marker.showInfoWindow();
                    }
                } else {
                    Log.e("RETROFIT",response.message()); // 정상적이지 않을경우 message 에 오류내용이 담겨온다.
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
```
