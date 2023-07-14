/**
Author: Owen Liu
Date: Thursday, July 14, 2023
Description: GUI-Based blackjack game program with randomly dealed cards from a shuffled deck.
 **/
public class frmU3A3AST extends javax.swing.JFrame {
    public frmU3A3AST() {
        initComponents();
    }
    final int SHUFFLE_TIMES = 4;
    //declare constant to store number of times deck is shuffled
    boolean isPlaying = false;
    //declare variable to store whether game is being played
    String [] strDeckArr = new String[52];
    //declare array to store all the cards in the deck
    int intOppTotal;
    //declare variable to store opponent total
    int intUserTotal;
    //declare variable to store user total
    int intCardNum;
    //declare variable to store number of cards taken from the deck
    int intEarnings;
    //declare variable to store earnings
    String strUserCards;
    //declare variable to store user's cards (not stored in array because array has limited size)
    String [] strOppCardsArr = new String[2];
    //declare array to store opponent's cards 
    String [] strSymbolsArr = {"♦", "♣", "♥", "♠"};
    //declare array to store card symbols
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEnter = new javax.swing.JButton();
        lblAICard1 = new javax.swing.JLabel();
        lblAICard2 = new javax.swing.JLabel();
        lblYou = new javax.swing.JLabel();
        lblOpponent = new javax.swing.JLabel();
        lblUserCards = new javax.swing.JLabel();
        lblAIC2 = new javax.swing.JLabel();
        lblAIC1 = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        lblEarnings = new javax.swing.JLabel();
        lblGameMsg = new javax.swing.JLabel();
        lblUserTotal = new javax.swing.JLabel();
        lblAITotal = new javax.swing.JLabel();
        txtCmd = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnEnter.setText("Enter");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        lblAICard1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAICard1.setText("Card 1");

        lblAICard2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAICard2.setText("Card2 ");

        lblYou.setText("YOU");

        lblOpponent.setText("OPPONENT");

        lblUserCards.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        lblUserCards.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserCards.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblAIC2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        lblAIC2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAIC2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblAIC1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        lblAIC1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAIC1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblBalance.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblBalance.setText("Balance: 1000");

        lblEarnings.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEarnings.setText("Earnings: 0");

        lblGameMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGameMsg.setText("type \"play\"!");

        lblUserTotal.setText("Total: 0");

        lblAITotal.setText("Total: ?");

        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblTitle.setText("BLACKJACK");

        lblDescription.setText("Get as close as you can to 21 without going over! Type \"play\" to start!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUserTotal)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lblYou)))
                        .addGap(30, 30, 30)
                        .addComponent(lblUserCards, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOpponent, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lblAITotal)
                                .addGap(18, 18, 18)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAIC1)
                            .addComponent(lblAICard1))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAICard2)
                            .addComponent(lblAIC2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGameMsg)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnEnter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCmd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblEarnings, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBalance, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDescription)
                    .addComponent(lblTitle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescription)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblAICard1)
                                .addComponent(lblAICard2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblAIC1)
                                .addComponent(lblAIC2)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblOpponent, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblAITotal)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBalance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEarnings)
                        .addGap(12, 12, 12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtCmd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGameMsg)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblYou, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUserTotal)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblUserCards)
                        .addGap(59, 59, 59))))
        );

        pack();
    }// </editor-fold>                        

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        String strCmd = txtCmd.getText();
        //declare variable to read user command
        if ((strCmd.equals("play")) && (isPlaying == false)){
            //executes lines if the command is "play" and a game is not being played                        
            for (int i = 0; i < 4; i ++){
                //executes lines 4 times
                strDeckArr[0 + i * 13] = strSymbolsArr[i] + "A";
                //generates an A card for each suite
                for (int j = 1; j < 10; j ++){
                    //executes lines 9 times 
                    strDeckArr[j + i * 13] = strSymbolsArr[i] + (j + 1);
                    //generates 2-10 cards for each suite
                }
                strDeckArr[10 + i * 13] = strSymbolsArr[i] + "J";
                //generates a J card for each suite
                strDeckArr[11 + i * 13] = strSymbolsArr[i] + "Q";
                //generates a Q card for each suite
                strDeckArr[12 + i * 13] = strSymbolsArr[i] + "K";
                //generates a K card for each suite
            }
            for (int i = 0; i < SHUFFLE_TIMES; i ++){
                //executes lines four times (shuffles deck four times)
                for (int j = 0; j < strDeckArr.length; j ++){
                    //executes lines 52 times
                    int intTemp = (int)(Math.random() * 52);
                    //declare variable to store index of random card
                    String strTemp = strDeckArr[intTemp];
                    //store random card in string
                    strDeckArr[intTemp] = strDeckArr[j];
                    //switch random card with indexed card
                    strDeckArr[j] = strTemp;
                    //switch indexed card with random card
                }
            }
            strUserCards = strDeckArr[0] + " " + strDeckArr[1];
            //gives user first two cards
            strOppCardsArr[0] = strDeckArr[2];
            //gives opponent 3rd card
            strOppCardsArr[1] = strDeckArr[3];
            //gives opponent 4th card            
            lblAIC1.setText(strOppCardsArr[0]);
            //displays opponents 1st card
            lblAIC2.setText("??");  
            //hides opponents 2nd card
            intOppTotal = 0;
            //resets opponents card total
            for (int i = 0; i < strOppCardsArr.length; i ++){
                //executes lines for each card that opponent has
                if ((strOppCardsArr[i].charAt(1) == 'J') || (strOppCardsArr[i].charAt(1) == 'Q') || (strOppCardsArr[i].charAt(1) == 'K') || (strOppCardsArr[i].charAt(1) == '1')){
                    //executes if card is a J, Q, K,or 10
                    intOppTotal = intOppTotal + 10;
                    //adds 10 to opponent total
                }
                else if (strOppCardsArr[i].charAt(1) != 'A'){
                    //executes if card is a number other than 10
                    String strValue = "" + strOppCardsArr[i].charAt(1);
                    //converts char value to string
                    intOppTotal = intOppTotal + Integer.parseInt(strValue);
                    //converts string to integer and adds to opponent total
                }
                else if (strOppCardsArr[i].charAt(1) == 'A'){
                    //executes if card is an ace
                    intOppTotal = intOppTotal + 11;
                    //adds 11 to opponent total
                }
            }
            intUserTotal = 0;
            //resets user card total
            for (int i = 1; i < strUserCards.length(); i = i + 3){
                //iterates through each character that corresponds to card value
                if ((strUserCards.charAt(i) == 'J') || (strUserCards.charAt(i) == 'Q') || (strUserCards.charAt(i) == 'K')){
                    //executes if card is a J, Q, or K
                    intUserTotal = intUserTotal + 10;
                    //adds 10 to user total
                }
                else if (strUserCards.charAt(i) == '1'){
                    intUserTotal = intUserTotal + 10;
                    //executes if card is a 10
                    i ++;                   
                    //adds 1 to i (because 10 is two digits)
                }
                else if (strUserCards.charAt(i) != 'A'){
                    //executes if card is a number other than 10                    
                    String strValue = "" + strUserCards.charAt(i);
                    //converts char of card value to string
                    intUserTotal = intUserTotal + Integer.parseInt(strValue);
                    //converst string to integer and adds to user total
                }
                else if (strUserCards.charAt(i) == 'A'){
                    //executes if card is an ace
                    intUserTotal = intUserTotal + 11;
                    //adds 11 to user total
                }
            }            
            intCardNum = 4;
            //move to fifth card (4 cards already drawn)
            isPlaying = true;
            //tells program game is being played
            lblGameMsg.setText("options: hit, stand");
            //updates game message to display user options
        }
        else if ((strCmd.equals("play")) && (isPlaying == true)){
            //executes if user enters command play and game is already being played
            lblGameMsg.setText("You're already playing!");
            //updates game message to tell user game is already being played
        }
        else if (strCmd.equals("hit") && (isPlaying == true)){
            //executes if user enters hit command and game is being played
            int intAces = 0;
            //declares variable to store number of aces that user has
            strUserCards = strUserCards + " " + strDeckArr[intCardNum];
            //draws next card from deck into user hand
            intUserTotal = 0;
            //reset user total
            for (int i = 1; i < strUserCards.length(); i = i + 3){
                //iterates through each character that corresponds to card value
                if ((strUserCards.charAt(i) == 'J') || (strUserCards.charAt(i) == 'Q') || (strUserCards.charAt(i) == 'K')){
                    //executes if card is a J, Q, or K
                    intUserTotal = intUserTotal + 10;
                    //adds 10 to user total
                }
                else if (strUserCards.charAt(i) == '1'){
                    //executes if card is a 10
                    intUserTotal = intUserTotal + 10;
                    //adds 10 to user total
                    i ++;
                    //skips a character
                    
                }
                else if (strUserCards.charAt(i) != 'A'){
                    //executes if card is a number other than 10
                    String strValue = "" + strUserCards.charAt(i);
                    //converts char of card value to string
                    intUserTotal = intUserTotal + Integer.parseInt(strValue);
                    //converst string to integer and adds to user total
                    
                }
                else if (strUserCards.charAt(i) == 'A'){
                    //executes if card is an ace
                    intAces ++;
                    //adds an ace
                }
            }
            for (int i = 0; i < intAces; i ++){
                //executes for each ace in user hand
                if (intUserTotal + 11 < 21){
                    //executes if adding 11 would not bust user
                        intUserTotal = intUserTotal + 11;
                        //adds 11 to user total
                    }
                    else{
                    //executes if adding 11 would bust user
                       intUserTotal = intUserTotal + 1; 
                       //adds 1 to user total
                    }                    
            }
            intCardNum ++;
            //move to next card in deck
            if (intUserTotal > 21){
                //executes if user busted
                lblUserTotal.setText("Total: " + intUserTotal);
                //updates user total display
                lblUserCards.setText(strUserCards);
                //updates user cards display
                lblGameMsg.setText("You have busted!");
                //updates game message to tell user that they have busted
                lblAIC2.setText(strOppCardsArr[1]);
                //reveals opponent's second card
                lblAITotal.setText("Total: " + intOppTotal);
                //reveals opponent's total 
                isPlaying = false;
                //ends the game
            }
        }
        else if (strCmd.equals("stand") && (isPlaying == true)){
            //executes if user command is stand and a game is being played
            lblAIC2.setText(strOppCardsArr[1]);
            //reveals opponents second card
            lblAITotal.setText("Total: " + intOppTotal);
            //reveals opponents card total
            if (intUserTotal > intOppTotal){
                //executes if user was closer to 21
                lblGameMsg.setText("You won!");
                //updates game message to tell user they won
                intEarnings = intEarnings + 200;
                //adds 200 dollars to user earnings
                lblEarnings.setText("Earnings: " + intEarnings);
                //updates earnings display
                lblBalance.setText("Balance: " + (intEarnings + 1000));
                //updates balance display
            }
            else if (intUserTotal == intOppTotal){
                //executes if user and opponent tied
                lblGameMsg.setText("Draw!");
                //updates game message to tell user they tied                
            }
            else if (intUserTotal < intOppTotal){
                //executes if opponent was closer to 21
                lblGameMsg.setText("You lost!");
                //updates game message to tell user they lost
                intEarnings = intEarnings - 200;
                //subtracts 200 dollars from user earnings
                lblEarnings.setText("Earnings: " + intEarnings);
                //updates earnings display
                lblBalance.setText("Balance: " + (intEarnings + 1000));
                //updates balance display
            }
            isPlaying = false;
            //tells program game ended
            
        }
        if (isPlaying == true){
            //executes if game is being played regardless of command type
            lblUserTotal.setText("Total: " + intUserTotal);
            //updates user total display
            lblUserCards.setText(strUserCards);
            //updates user cards display
            lblAITotal.setText("Total: ??");
            //hides opponent opponent total
            
        }    
    }                                        
     
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmU3A3AST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmU3A3AST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmU3A3AST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmU3A3AST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmU3A3AST().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    public javax.swing.JButton btnEnter;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAIC1;
    private javax.swing.JLabel lblAIC2;
    private javax.swing.JLabel lblAICard1;
    private javax.swing.JLabel lblAICard2;
    private javax.swing.JLabel lblAITotal;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblEarnings;
    private javax.swing.JLabel lblGameMsg;
    private javax.swing.JLabel lblOpponent;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserCards;
    private javax.swing.JLabel lblUserTotal;
    private javax.swing.JLabel lblYou;
    private javax.swing.JTextField txtCmd;
    // End of variables declaration                   
}
