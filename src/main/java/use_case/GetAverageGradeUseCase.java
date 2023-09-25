package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

import java.util.ArrayList;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        // TODO: Get average grade for all students in your team.
        Team team = gradeDB.getMyTeam();
        String[] teamMembers = team.getMembers();
        ArrayList<Integer> allGrades = new ArrayList<>();
        GetGradeUseCase getGradeUseCase = new GetGradeUseCase(gradeDB);

        for (String member : teamMembers){
            allGrades.add(getGradeUseCase.getGrade(member, course).getGrade());
        }

        float result = 0.0f;

        for (Integer grade : allGrades){
            result += grade;
        }

        result = result / allGrades.size();

        return result;
    }
}
