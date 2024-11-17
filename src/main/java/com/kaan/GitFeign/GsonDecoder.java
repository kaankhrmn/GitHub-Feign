package com.kaan.GitFeign;
import com.google.gson.Gson;
import feign.Response;
import feign.codec.Decoder;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class GsonDecoder implements Decoder {
    private final Gson gson;

    // Yapıcı metot ile Gson nesnesini oluşturuyoruz
    public GsonDecoder() {
        this.gson = new Gson();
    }

    @Override
    public Object decode(Response response, Type type) throws IOException {
        // Yanıtın gövdesini alıp Gson kullanarak belirli bir Java nesnesine dönüştürüyoruz
        try (InputStreamReader reader = new InputStreamReader(response.body().asInputStream())) {
            return gson.fromJson(reader, type);
        }
    }
}
