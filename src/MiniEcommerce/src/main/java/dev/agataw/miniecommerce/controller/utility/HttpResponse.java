package dev.agataw.miniecommerce.controller.utility;

import com.google.gson.JsonElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpResponse {
        private String statusResponse;
        private JsonElement data;

}