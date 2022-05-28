
/*
/ ----------------------------------------------------------------------------------
/     This class, creates a GUI (graphical user interface) for the BMI calculator.
/     The calculator, calculates the user's status, according to the known .
/     (more details in the raedMe file).
/ ----------------------------------------------------------------------------------
 */

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;
import java.util.stream.IntStream;


public class View extends Panel {

    // Define all the components that will be needed in the program.
    private final JFrame frame = new JFrame("BMI calculator");
    private JPanel mainPanel, detailsPanel, centerPanel, titlePanel, sumPanel, resultPanel;
    private JLabel bmiResult, idealWeightResult, status;
    private final JLabel titleText = new JLabel ("BMI calculator");
    private final JButton sum = new JButton("Sum");
    private JTextField actualWeightBox;
    private JComboBox<String> ageBox;
    private JSlider slider;
    private final ButtonGroup genderGroup = new ButtonGroup();
    private final ButtonGroup bodyFrameGroup = new ButtonGroup();
    private final Color color = new Color(191, 205, 240);
    private final Color color2 = new Color(231, 225, 172);
    private final Dimension mainDimension = new Dimension(940,550);
    private final Dimension detailsPanelDimension  = new Dimension(160,340);
    private final Dimension resultPanelDimension = new Dimension(230,340);
    private final Dimension centerPanelDimension  = new Dimension(550,350);
    private final Dimension titlePanelDimension  = new Dimension(940,80);
    private final Dimension sumPanelDimension = new Dimension(940,120);
    private final Font textFont1 = new Font("Arial", Font.BOLD,25);
    private final Font textFont2 = new Font("Arial", Font.BOLD,40);
    private final Font textFont3 = new Font("Arial", Font.BOLD,18);

    // Constructor, initializes all components
    View(){

        initTitlePanel();
        initDetailsPanel();
        initResultPanel();
        initCenterPanel();
        initSumPanel();
        initMainPanel();
        initFrame();

    }

    /*
    / All initPanel methods:
    / Used to define each panel individually
    / and add all the components to the same panel.
     */
    private void initTitlePanel(){
        titlePanel = new JPanel();
        titlePanel.setPreferredSize(titlePanelDimension);
        titlePanel.setBackground(color);
        titlePanel.add(titleText);
        titleText.setFont(textFont2);
    }

    private void initDetailsPanel(){
        detailsPanel = new JPanel();
        JLabel name = new JLabel("Name");
        JLabel lastName = new JLabel("Last Name");
        JLabel age = new JLabel("Age");
        JTextField nameBox = new JTextField();
        JTextField lastNameBox = new JTextField();
        ageBox = new JComboBox<>(setComboBox());

        name.setFont(textFont1);
        lastName.setFont(textFont1);
        age.setFont(textFont1);
        nameBox.setFont(textFont3);
        lastNameBox.setFont(textFont3);
        ageBox.setFont(textFont3);
        nameBox.setBackground(color2);
        lastNameBox.setBackground(color2);
        ageBox.setBackground(color2);

        name.setBounds(35,30,90,25);
        nameBox.setBounds(25,60,90,25);
        lastName.setBounds(5,115,130,25);
        lastNameBox.setBounds(25,145,90,25);
        age.setBounds(45,190,90,25);
        ageBox.setBounds(40,220,60,25);

        detailsPanel.setPreferredSize(detailsPanelDimension);
        detailsPanel.setBackground(color);
        detailsPanel.setLayout(null);
        detailsPanel.add(name);
        detailsPanel.add(nameBox);
        detailsPanel.add(lastName);
        detailsPanel.add(lastNameBox);
        detailsPanel.add(age);
        detailsPanel.add(ageBox);
    }

    private void initCenterPanel(){

        centerPanel = new JPanel();
        slider =new JSlider(140,190,140);
        JLabel gender = new JLabel("Gender:");
        JLabel bodyFrame = new JLabel("Body-frame:");
        JLabel sliderLabel = new JLabel(""+ slider.getValue());
        JLabel height = new JLabel("Height:");
        JLabel actualWeight = new JLabel("Actual Weight:");
        JRadioButton male = new JRadioButton("male");
        JRadioButton female = new JRadioButton("female");
        JRadioButton other = new JRadioButton("other");
        JRadioButton small = new JRadioButton("small");
        JRadioButton medium = new JRadioButton("medium");
        JRadioButton large = new JRadioButton("large");
        actualWeightBox = new JTextField();

        actualWeight.setFont(textFont1);
        actualWeight.setBounds(310,30,190,25);
        actualWeightBox.setBounds(360,70,70,25);
        actualWeightBox.setBackground(color);
        actualWeightBox.setFont(textFont3);
        height.setBounds(210,155,90,25);
        height.setFont(textFont1);
        slider.setBounds(80,195,350,45);
        slider.setPaintTicks(true);
        slider.setBackground(color2);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(10);
        slider.setPaintLabels(true);
        slider.setFont(new Font("Arial",Font.PLAIN,15));
        sliderLabel.setBounds(230,250,50,22);
        sliderLabel.setFont(new Font("Arial",Font.PLAIN,20));
        slider.addChangeListener(e -> sliderLabel.setText(""+ slider.getValue()));

        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        bodyFrameGroup.add(small);
        bodyFrameGroup.add(medium);
        bodyFrameGroup.add(large);

        gender.setFont(textFont1);
        gender.setBounds(30,30,100,25);
        male.setBounds(35,58,100,20);
        female.setBounds(35,83,100,20);
        other.setBounds(35,108,100,20);
        male.setBackground(color2);
        female.setBackground(color2);
        other.setBackground(color2);
        male.setFont(textFont3);
        female.setFont(textFont3);
        other.setFont(textFont3);

        bodyFrame.setFont(textFont1);
        bodyFrame.setBounds(140,30,150,25);
        small.setBounds(155,58,100,20);
        medium.setBounds(155,83,100,20);
        large.setBounds(155,108,100,20);
        small.setBackground(color2);
        medium.setBackground(color2);
        large.setBackground(color2);
        small.setFont(textFont3);
        medium.setFont(textFont3);
        large.setFont(textFont3);
 
        centerPanel.setPreferredSize(centerPanelDimension);
        centerPanel.setBackground(color2);
        centerPanel.setLayout(null);
        centerPanel.add(gender);
        centerPanel.add(male);
        centerPanel.add(female);
        centerPanel.add(other);
        centerPanel.add(bodyFrame);
        centerPanel.add(small);
        centerPanel.add(medium);
        centerPanel.add(large);
        centerPanel.add(actualWeight);
        centerPanel.add(actualWeightBox);
        centerPanel.add(height);
        centerPanel.add(slider);
        centerPanel.add(sliderLabel);

    }

    private void initSumPanel(){
        sumPanel = new JPanel();
        sumPanel.setPreferredSize(sumPanelDimension);
        sumPanel.setLayout(null);
        sumPanel.setBackground(color);
        sumPanel.add(sum);

        sum.setBounds(400,30,120,60);
        sum.setFont(new Font("Guttmann Yad-Brush",Font.BOLD,35));
        sum.setBackground(color2);
    }

    private void initResultPanel(){
        resultPanel = new JPanel();
        JLabel bmiTitle = new JLabel("Your bmi:");
        JLabel idealWeightTitle = new JLabel("The ideal weight:");
        JLabel statusTitle = new JLabel("Status:");
        bmiResult = new JLabel("");
        idealWeightResult = new JLabel("");
        status = new JLabel("");

        bmiResult.setFont(textFont1);
        idealWeightResult.setFont(textFont1);
        status.setFont(textFont1);
        bmiTitle.setFont(textFont1);
        idealWeightTitle.setFont(textFont1);
        statusTitle.setFont(textFont1);

        bmiResult.setBounds(70,60,120,30);
        idealWeightResult.setBounds(70,235,120,30);
        status.setBounds(25,145,200,30);
        bmiTitle.setBounds(45,30,120,30);
        idealWeightTitle.setBounds(10,205,215,30);
        statusTitle.setBounds(65,115,120,30);


        resultPanel.setPreferredSize(resultPanelDimension);
        resultPanel.setLayout(null);
        resultPanel.setBackground(color);
        resultPanel.add(bmiTitle);
        resultPanel.add(idealWeightTitle);
        resultPanel.add(statusTitle);
        resultPanel.add(bmiResult);
        resultPanel.add(idealWeightResult);
        resultPanel.add(status);
    }

    // Add all the panels to it and then add the main panel to the main frame.
    private void initMainPanel(){
        mainPanel = new JPanel();
        mainPanel.setSize(mainDimension);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(color);
        mainPanel.add(titlePanel,BorderLayout.NORTH);
        mainPanel.add(detailsPanel,BorderLayout.WEST);
        mainPanel.add(resultPanel,BorderLayout.EAST);
        mainPanel.add(centerPanel,BorderLayout.CENTER);
        mainPanel.add(sumPanel,BorderLayout.SOUTH);
    }

    // Used to define the main frame and add the main panel to it.
    private void initFrame(){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(mainDimension);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getContentPane().add(mainPanel);
    }

    // Set numbers for ComboBox (between 1 and 120)
    private String[] setComboBox(){
        int[] rangeArr = IntStream.rangeClosed(1, 120).toArray();
        String[] toStringArr = new String[120];
        for (int i = 0; i < rangeArr.length; i++) {
            toStringArr[i] = Integer.toString(rangeArr[i]);
        }
        return toStringArr;
    }

    // Returns the user's height in meters.
    public double getUserHeightInMeter(){
        return (slider.getValue()*0.01);
    }

    // Returns the user's height (original height)
    public double getUserHeight(){
        return slider.getValue();
    }

    /*
    / The following methods,
    / Receives all the variables/components, for
    / the purpose of connecting to the controller.
     */
    public JButton getSum() {
        return sum;
    }
    public double getActualWeightBox() {
        try {// In case the actual weight box is empty.
            return Double.parseDouble(actualWeightBox.getText());
        }
        catch (NumberFormatException ignored) {
        }
        return 0;
    }

    public int getAgeBox() {
        return ageBox.getSelectedIndex()+1;
    }

    public String getBodyFrameGroupText() {
        for (Enumeration<AbstractButton> buttons = bodyFrameGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    public double getBodyFrameGroupNumber() {
        double slimness = -1;
        try { // In case the body frame is empty
            if (getBodyFrameGroupText().equals("small")) {
                slimness = 0.9;
            } else if (getBodyFrameGroupText().equals("medium")) {
                slimness = 1;
            } else if (getBodyFrameGroupText().equals("large")) {
                slimness = 1.1;
            }
        }
        catch(NullPointerException ignored){
        }
        return slimness;
    }

    /*
    / The following two methods, define
    / the color/text according to the result.
     */
    public void setBmiTextColor(Color color){
        this.bmiResult.setForeground(color);
        this.idealWeightResult.setForeground(color);
        this.status.setForeground(color);
    }

    public void setResultText(String bmi, String status, String idealWeight){
        this.bmiResult.setText(bmi);
        this.idealWeightResult.setText(idealWeight);
        this.status.setText(status);
    }

}
