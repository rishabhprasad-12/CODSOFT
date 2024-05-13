import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class StudentTableModel extends AbstractTableModel {

    // Column names for the table model
    private String[] columnNames = {"Name", "Roll No.", "Father Name", "Address", "Phone No.", "Email", "10th Marks", "12th Marks", "Course", "Branch"};

    // Data for the table model, stored as a vector of rows
    private Vector<Vector<Object>> data;

    /**
     * Constructs a new StudentTableModel with the given ResultSet.
     * @param rs The ResultSet to populate the table model with.
     */
    StudentTableModel(ResultSet rs) {
        data = new Vector<>();
        try {
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("name"));
                row.add(rs.getString("roll"));
                row.add(rs.getString("fname"));
                row.add(rs.getString("address"));
                row.add(rs.getString("phone"));
                row.add(rs.getString("email"));
                row.add(rs.getString("class_X"));
                row.add(rs.getString("class_XII"));
                row.add(rs.getString("course"));
                row.add(rs.getString("branch"));
                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the number of rows in the table model.
     * @return The number of rows.
     */
    @Override
    public int getRowCount() {
        return data.size();
    }

    /**
     * Returns the number of columns in the table model.
     * @return The number of columns.
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Returns the name of the column at the given index.
     * @param column The index of the column.
     * @return The name of the column.
     */
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * Returns the value at the given row and column indices.
     * @param rowIndex The index of the row.
     * @param columnIndex The index of the column.
     * @return The value at the given row and column indices.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex).get(columnIndex);
    }
}