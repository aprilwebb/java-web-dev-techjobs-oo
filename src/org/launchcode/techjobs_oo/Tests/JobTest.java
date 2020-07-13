package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job job1;
    Job job2;

    @Before
    public void createJob(){
       job1 = new Job();
       job2 = new Job();
    }

    @Test
    public void testSettingJobId (){
        assertEquals(14, job1.getId());
        assertEquals(15, job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job1.getName());
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(job1, job2);
    }

    @Test
    public void testToStringPrintsBlankLines(){
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
            assertEquals("" + job1, job1.toString());
    }

    @Test
    public void testToStringPrintsLabelOnNewLines(){
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: " + job1.getId() +
                "\nName: " + job1.getName() +
                "\nEmployer: " + job1.getEmployer() +
                "\nLocation: " + job1.getLocation() +
                "\nPosition Type: " + job1.getPositionType() +
                "\nCore Competency: " + job1.getCoreCompetency() +
                "\n", job1.toString());
    }

    @Test
    public void testToStringEmptyReturnsNoData() {
        job2 = new Job("", new Employer(""), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: " + job2.getId() +
                "\nName: " + job2.getName() +
                "\nEmployer: " + "Data not available." +
                "\nLocation: " + job2.getLocation() +
                "\nPosition Type: " + job2.getPositionType()  +
                "\nCore Competency: " + job2.getCoreCompetency() +
                "\n", job2.toString());
    }
}
