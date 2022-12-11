package com.cabas;

import com.cabas.entity.Area;
import com.cabas.entity.Citizen;
import com.cabas.entity.City;
import com.cabas.repository.AreaRepository;
import com.cabas.repository.CitizenRepository;
import com.cabas.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
@AllArgsConstructor
public class Runner implements CommandLineRunner {

    private final CityRepository cityRepository;
    private final AreaRepository areaRepository;
    private final CitizenRepository citizenRepository;


    @Override
    public void run(String... args) throws Exception {
        var area1 = areaRepository.save(Area.builder()
                .areaCode("A1")
                .build());

        var area2 = areaRepository.save(Area.builder()
                .areaCode("A2")
                .build());

        var city1 = cityRepository.save(City.builder()
                .cityName("city 1 - area 1")
                .area(area1)
                .build());

        var city2 = cityRepository.save(City.builder()
                .cityName("city 2 - area 1")
                .area(area1)
                .build());


        var city3 = cityRepository.save(City.builder()
                .cityName("city 3 - area 2")
                .area(area2)
                .build());


        Citizen citizen1 = citizenRepository.save(Citizen.builder()
                .firstName("aaa")
                .lastName("aaa")
                .phone("111-22-33")
                .city(city1)
                .build());

        Citizen citizen2 = citizenRepository.save(Citizen.builder()
                .firstName("bbb")
                .lastName("bbb")
                .phone("222-33-44")
                .city(city2)
                .build());

        Citizen citizen3 = citizenRepository.save(Citizen.builder()
                .firstName("ccc")
                .lastName("ccc")
                .phone("333-44-55")
                .city(city3)
                .build());
    }
}
