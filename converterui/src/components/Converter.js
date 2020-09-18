import React, {Component} from 'react';
import Service from './Service';
import List from './List';
import './style.css';

class Converter extends Component {
    constructor(props) {
        super(props);
        this.state = {
            convertFrom: '',
            convertTo: '',
            amount: 0.0,
            convertedAmount: 0.0
        }
    }

    inputChange = (event) => {
        this.setState({[event.target.name]: event.target.value});
    };

    submitForm = (event) => {
        event.preventDefault();
        
        const data = {
            convertFrom: this.state.convertFrom,
            convertTo: this.state.convertTo,
            amount: this.state.amount,
        };
        console.log(data);

        Service.convertCurrency(data)
            .then(response => {this.setState({convertedAmount: response.data})
            console.log(response.data);
        });

    }

    render() {
        return (

            <div className="card">
                <div className="text-center">
                    <h2 className="pt-3">Currency Converter</h2>
                </div>
                
                <form onSubmit={this.submitForm}>
                    <div className="form-group">
                        <label htmlFor="amount">Amount</label>
                        <input className="form-control" type="number" id="amount" name="amount" 
                         onChange={this.inputChange}></input>
                    </div>
                    
                
                        <List inputChange={this.inputChange} convert={"convertFrom"} />
                  
                        <List inputChange={this.inputChange} convert={"convertTo"} />
                                     
                    <div className="center">
                    <button type="submit" className="btn btn-info">Convert</button>
                    </div>
                    
                </form>
              
                <div className="text-center">
                    <label for="">Converted Amount</label>
                    <input type="number" className="form-control input-size" value={this.state.convertedAmount}></input>
                </div>
                
            </div>
        )
    }

}

export default Converter