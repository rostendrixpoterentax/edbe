package ru.kasovsky.edbe.hsql.mock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.kasovsky.edbe.hsql.dto.SmallCreateDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component
public class Big {

    private String get(Class<?> classs, String path) {

        InputStream inputStream = classs.getClassLoader().getResourceAsStream(path);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            String content = br.lines().collect(Collectors.joining("\n"));
            return content;
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    public List<SmallCreateDto> get(Long power) {

        List<SmallCreateDto> list = new ArrayList<>();
        for (int i = 0; i < power; i++) {
            SmallCreateDto dto = new SmallCreateDto();
            dto.setUuid(UUID.randomUUID());
            dto.setName(dto.getUuid().toString());
            String body = i % 2 == 0 ? get(this.getClass(), "data/eComCommon.xsd") : get(this.getClass(), "data/SharedCommon.xsd");
            dto.setData(body);
            list.add(dto);
        }
        return list;
    }
}

