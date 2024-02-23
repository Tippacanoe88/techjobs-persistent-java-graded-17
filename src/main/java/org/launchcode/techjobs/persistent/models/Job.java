package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.*;
import org.launchcode.techjobs.persistent.models.AbstractEntity;
import org.launchcode.techjobs.persistent.models.Employer;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Entity
public class Job extends AbstractEntity {

    @ManyToMany
    @JoinTable(
            name = "job_skill",
            joinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    @ManyToOne
    private Employer employer;

    public Job() {
    }

    public Job(Employer employer, @RequestParam List<Skill> skills) {
        super();
        this.employer = employer;
        this.skills = skills;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + getId() +
                ", employer=" + employer + '\'' +
                ", skills=" + skills +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(employer, job.employer) &&
                Objects.equals(skills, job.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employer, skills);
    }
}
