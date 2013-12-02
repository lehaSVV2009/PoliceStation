package com.kadet.java.swing.pagination;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Date: 02.12.13
 * Time: 4:39
 *
 * @author Кадет
 */
public class PaginationPanel extends JPanel implements ActionListener{

    private Window owner;

    public static final int START_PAGE = 1;

    private int itemsPerPage;
    private int currentPage = START_PAGE;

    private JPanel pagePanel;
    private List<Component> components;

    private JPanel pageButtonsPanel;
    private List<JButton> pageNumberButtons;

    private ClickPageStrategy clickPageStrategy;

    public PaginationPanel(Window owner, int itemsPerPage) {
        this.owner = owner;
        this.itemsPerPage = itemsPerPage;
        initialize();
        initializeComponents();
        addComponents();
    }

    private void initialize () {
        setLayout(new BorderLayout());
    }

    protected void initializeComponents() {
        pagePanel = new JPanel();
        pagePanel.setLayout(
                new GridLayout(0, 1));

        components = new ArrayList<Component>();

        pageButtonsPanel = new JPanel();
        pageButtonsPanel.setLayout(
                new FlowLayout());
        pageNumberButtons = new ArrayList<JButton>();
    }

    protected void addComponents() {

        for (Component component : components) {
            pagePanel.add(component);
        }
        add(pagePanel, BorderLayout.CENTER);

        for (JButton button : pageNumberButtons) {
            pageButtonsPanel.add(button);
        }
        add(pageButtonsPanel, BorderLayout.SOUTH);

    }

    private void removeComponents () {
        for (Component component : components) {
            pagePanel.remove(component);
        }
        components.clear();
        remove(pagePanel);

        for (JButton button : pageNumberButtons) {
            pageButtonsPanel.remove(button);
        }
        pageNumberButtons.clear();
        remove(pageButtonsPanel);
    }

    /**
     * Create new buttons for pagination (1, 2, 3, 4, ...)
     * @param totalPagesNumber
     * @param currentPage
     */
    private void createPageButtons (int totalPagesNumber, int currentPage) {
        for (int buttonNumber = 1; buttonNumber <= totalPagesNumber; ++buttonNumber) {
            JButton button = new JButton(String.valueOf(buttonNumber));
            button.addActionListener(this);
            button.setForeground(
                    currentPage == buttonNumber ? Color.YELLOW : Color.GRAY);
            pageNumberButtons.add(button);
        }
    }


    /**
     * Update PagePanel and ButtonsPanel
     * 1) Remove all components from main panel
     * 2) Create new pageButtons
     * 3) Set what will be shown at the page panel (List<Component>)
     * 4) Add PagePanel and ButtonsPanel
     * 5) Update owner
     *
     * @param totalItems
     * @param itemsPerPage
     * @param currentPage
     * @param components
     */
    protected void updateComponents(int totalItems, int itemsPerPage, int currentPage, List<Component> components) {
        removeComponents();
        this.itemsPerPage = itemsPerPage;
        int totalPages
                = calculateNumberOfButtons(totalItems, itemsPerPage);
        createPageButtons(
                totalPages,
                currentPage
        );
        this.components = components;
        addComponents();
        updateOwner();
    }

    private int calculateNumberOfButtons (int totalItems, int itemsPerPage) {
        int totalPagesNumber =  totalItems / itemsPerPage;
        if (totalItems % itemsPerPage > 0) {
            totalPagesNumber = totalPagesNumber + 1;
        }
        if (totalItems <= itemsPerPage) {
            totalPagesNumber = 1;
        }
        return totalPagesNumber;
    }

    private void updateOwner () {
        owner.repaint();
        owner.revalidate();
    }

    public void clickPage (int currentPage, int itemsPerPage) {
        clickPageStrategy.clickPage(currentPage, itemsPerPage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        for (int buttonIndex = 0; buttonIndex < pageNumberButtons.size(); ++buttonIndex) {
            JButton button = pageNumberButtons.get(buttonIndex);
            if (source == button) {
                int pageNumber = buttonIndex + 1;
                clickPage(pageNumber, itemsPerPage);
                this.currentPage = pageNumber;
            }
        }
    }

    public void setClickPageStrategy(ClickPageStrategy clickPageStrategy) {
        this.clickPageStrategy = clickPageStrategy;
        clickPage(currentPage, itemsPerPage);
    }

    public Window getOwner() {
        return owner;
    }
}
