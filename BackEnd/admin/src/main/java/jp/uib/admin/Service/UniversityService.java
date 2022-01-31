package jp.uib.admin.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.uib.admin.model.University;
import jp.uib.admin.repository.UniversityRepository;
import jp.uib.admin.request.UniversityRequest;

@Service
@Transactional
public class UniversityService {

    @Autowired
    UniversityRepository universityRepository;

    public List<University> getAllPosts() {

        return universityRepository.findAll();
    }

    public University getPost(int id) {

        Optional<University> universityInfoOptional = universityRepository.findById(id);

        if (Objects.isNull(universityInfoOptional)) {
            try {
                throw new Exception("データがありません");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return universityInfoOptional.get();
    }

    public University add(UniversityRequest universityInfoRequest) {

        University university = University.builder()
                .name(universityInfoRequest.getName())
                .furikana(universityInfoRequest.getFurikana())
                .build();

        System.out.println(university);

        Integer universityInfonumber = universityRepository.create(university);

        System.out.println(universityInfonumber);

        return getPost(universityInfonumber);
    }

}
