public class Coordinates {
    private:
        int longitude;
        int latitude;
        int height;

        public:
            Coordinates(int p_longitude, int p_latitude, int p_height) {
                this.longitude = p_longitude;
                this.latitude = p_latitude;
                this.height = p_height;
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
                this.height = p_height;
            }

            

}