package com.sak2km.springboot.dto;

import com.sak2km.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void test_lombok() {
        String name = "test";
        int amount = 1000;

//        When
        HelloResponseDto dto = new HelloResponseDto(name, amount);

//        then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);


    }
}
