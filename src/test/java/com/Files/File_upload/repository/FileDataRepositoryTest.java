package com.Files.File_upload.repository;

import com.Files.File_upload.entity.FileData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.Optional;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
class FileDataRepositoryTest {

    @Autowired
    private FileDataRepository fileDataRepos;

    @Test
    void findByName() {
        FileData fl = FileData.builder().name("image_new")
                .type("text/plain")
                .filePath("C:/Users/PC/Folder/image_new").build();
        fileDataRepos.save(fl);
        Optional<FileData> filedt = fileDataRepos.findByName("image_new");

        assertThat("image_new", filedt.get().getName());

    }

    @AfterEach
    void tearDown() {

    }

    @BeforeEach
    void setUp() {

    }

    private void assertThat(String image, String name) {
        image.equals(name);
    }
}