package jp.uib.admin.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.uib.admin.model.University;
import jp.uib.admin.repository.UniversityRepository;
import jp.uib.admin.request.UniversityEditRequest;
import jp.uib.admin.request.UniversityRequest;

@Service
@Transactional
public class UniversityService {

    @Autowired
    UniversityRepository universityRepository;

    public List<University> getAllUniversities() {

        return universityRepository.findAll();
    }

    public University getUniversity(int id) {

        Optional<University> universityInfoOptional = universityRepository.findById(id);
        return universityInfoOptional.get();
    }

    public void add(UniversityRequest universityInfoRequest) {

        University university = University.builder()
                .name(universityInfoRequest.getName())
                .furikana(universityInfoRequest.getFurikana())
                .build();
        universityRepository.create(university);

    }

    public void delete(int id) {
        universityRepository.delete(id);
    }

    public void edit(UniversityEditRequest universityEditRequest) {
        University university = University.builder()
                .id(universityEditRequest.getId())
                .name(universityEditRequest.getName())
                .furikana(universityEditRequest.getFurikana())
                .build();

        universityRepository.edit(university);
    }

}
