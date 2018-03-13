package com.example.demo;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileListController {
	private static final Path VAR = FileSystems.getDefault().getPath("/","var", "service");
	@GetMapping(value="/etc")
	public String getConfigContent() throws IOException {
		return new String(Files.readAllBytes(FileSystems.getDefault().getPath("/","etc", "service.cfg")));
	}
	@GetMapping(value="/var")
	public String getVarContent() throws IOException {
		try(Stream<Path> list = Files.list(VAR)){
			return list.map(Path::toString).collect(Collectors.joining(","));
		}
	}


}
