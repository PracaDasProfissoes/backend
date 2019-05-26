package br.edu.opi.praca.excel_io.repositories;

import br.edu.opi.praca.excel_io.models.StudentTableRow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentTableRowRepository extends JpaRepository<StudentTableRow, Long> {

}
