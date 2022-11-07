package com.github.sansive;

import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class MatriculaTest {

    @Test
    public void getImporteThrowsException() throws Exception {
        Matricula matricula = new Matricula(null);
        assertThrows(Exception.class, () -> matricula.getImporte());
    }

    @Test
    public void getImporteTest() throws Exception {
        Asignatura asignatura = mock(Asignatura.class);
        when(asignatura.getImporte()).thenReturn(10.0);

        Vector<Asignatura> asignaturas = new Vector<Asignatura>();
        asignaturas.add(asignatura);
        asignaturas.add(asignatura);
        Matricula matricula = new Matricula(asignaturas);

        assertEquals(20.0, matricula.getImporte(), 0.01);
    }

    @Test
    public void getImporteInterationTest() throws Exception {
        Asignatura asignatura = mock(Asignatura.class);
        when(asignatura.getImporte()).thenReturn(10.0);

        Vector<Asignatura> asignaturas = new Vector<Asignatura>();
        asignaturas.add(asignatura);
        asignaturas.add(asignatura);
        Matricula matricula = new Matricula(asignaturas);

        matricula.getImporte();
        verify(asignatura, times(2)).getImporte();
    }
}
