package br.com.fintechDeQuebraeconomy.model;


    public enum Category {
        INCOME(1),
        EXPENSE(2),
        INVESTMENT(3),
        GOAL(4);

        private  int id;

        private Category(int id){
            this.id = id;

        }

        public int getId() {
            return id;
        }
    }
