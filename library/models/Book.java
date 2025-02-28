    package library.models;

    import Utils.Utils;

    public class Book {
        private static int count = 0;
        private String title;
        private int releaseYear;
        private String author;
        private String id;
        private boolean avaiable;

        public Book(String title, int releaseYear, String author) {
            count++;
            this.title = title;
            this.releaseYear = releaseYear;
            this.author = author;
            this.id = Utils.generateId('B',count);
            this.avaiable = true;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getReleaseYear() {
            return releaseYear;
        }

        public void setReleaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getId() {
            return id;
        }

        public boolean isAvaiable() {
            return avaiable;
        }

        public void setAvaiable(boolean avaiable) {
            this.avaiable = avaiable;
        }

        @Override
        public String toString() {
            return "Book ID: " + id + "\n" +
                   "Title: " + title + "\n" +
                   "Author: " + author + "\n" +
                   "Release Year: " + releaseYear;
        }


    }
