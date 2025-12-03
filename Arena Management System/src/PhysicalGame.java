
    public abstract class PhysicalGame extends Game {


        private double equipmentFeePerBooking;

        public PhysicalGame(String id, String name, int totalTables, double pricePerHour, double equipmentFeePerBooking) {
            super(id, name, totalTables, pricePerHour);
            if (equipmentFeePerBooking < 0) throw new IllegalArgumentException("equipment fee must be >= 0");
            this.equipmentFeePerBooking = equipmentFeePerBooking;
        }

        public double getEquipmentFeePerBooking() { return equipmentFeePerBooking; }
        public void setEquipmentFeePerBooking(double fee) {
            if (fee < 0) throw new IllegalArgumentException("fee must be >= 0");
            this.equipmentFeePerBooking = fee;
        }

        @Override
        public double calculateFinalPrice(int hours) {
            if (hours < 0) throw new IllegalArgumentException("hours must be >= 0");
            return (getPricePerHour() * hours) + equipmentFeePerBooking;
        }
    }


