public class Coordinates {
        private int longitude;
        private int latitude;
        private int height;

        
        public Coordinates(int p_longitude, int p_latitude, int p_height) {
                setHeight(p_height);
                setLatitude(p_latitude);
                setLongitude(p_longitude);
            }
        
            // Getters

        public int getLongitude() {
            return this.longitude;
        }
        
        public int getLatitude() {
            return this.latitude;
        }
        
        public int getHeight() {
            return this.height;
        }
        

        // Setters

        public void setLongitude(int p_longitude) {
            this.longitude = p_longitude;
        }

        public void setLatitude(int p_latitude) {
            this.latitude =  p_latitude;
        }

        public void setHeight(int p_height) {
            if(p_height < 0) {
                this.height = 0;
            } else if(p_height > 100) {
                this.height = 100;
            }
            this.height = p_height;
        }

        public String toString() {
            return "longitude: " + this.longitude + " latitude: " + this.latitude + " height: " + this.height;
        }

        public class InvalidCoordinates extends Exception {
            public InvalidCoordinates(String coordinate) {
                super("this coordinate " + coordinate + " must be positive 0 to 100");
            }
     }

}