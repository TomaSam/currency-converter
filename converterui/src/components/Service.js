import axios from 'axios';

class Service {
    convertCurrency(activity) {
        return axios.post(`http://localhost:8080/api/converter`, activity);
    }
}
export default new Service()