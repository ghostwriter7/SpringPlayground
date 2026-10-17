package com.rozplochowski.beans.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RequiredArgsConstructor
public class BannerLoader {

    private final Resource banner;

    @PostConstruct
    public void print() throws IOException {
        var path = Path.of(banner.getURI());
        try (var lines = Files.lines(path)) {
            lines.forEachOrdered(IO::println);
        }
    }
}
