/**
 *
 */
package com.pizzacontrol.utils;

import java.awt.Component;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 * @author tstepputtis
 *
 */
public class ExtJTable extends JTable {

	private String TableID;

	/**
	 *
	 */
	private static final long serialVersionUID = -2358946141134452320L;

	/**
	 *
	 */
	public ExtJTable() {
		super();
	}

	/**
	 *
	 */
	public ExtJTable(String tableName) {
		super();
		this.TableID = tableName;
	}

	/**
	 * @param numRows
	 * @param numColumns
	 */
	public ExtJTable(int numRows, int numColumns) {
		super(numRows, numColumns);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param rowData
	 * @param columnNames
	 */
	public ExtJTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dm
	 * @param cm
	 * @param sm
	 */
	public ExtJTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
		super(dm, cm, sm);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dm
	 * @param cm
	 */
	public ExtJTable(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dm
	 */
	public ExtJTable(String tableName, TableModel dm) {
		super(dm);
		this.TableID = tableName;
	}

	/**
	 * @param rowData
	 * @param columnNames
	 */
	public ExtJTable(Vector rowData, Vector columnNames) {
		super(rowData, columnNames);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param rowData
	 * @param columnNames
	 */
	public ExtJTable(String tableName, Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
		this.TableID = tableName;
	}

	public String getTableID() {
		return TableID;
	}

	public void setTableID(String tableID) {
		TableID = tableID;
	}

	public void resizeColumnWidth() {
		final TableColumnModel columnModel = getColumnModel();
		for (int column = 0; column < getColumnCount(); column++) {
			int width = 25; // Min width
			for (int row = 0; row < getRowCount(); row++) {
				TableCellRenderer renderer = getCellRenderer(row, column);
				Component comp = prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}

			if (width > 300)
				width = 300;

			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}
}
