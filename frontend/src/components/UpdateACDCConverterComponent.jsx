import React, { Component } from 'react'
import ACDCConverterService from '../services/ACDCConverterService';

class UpdateACDCConverterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateACDCConverter = this.updateACDCConverter.bind(this);

    }

    componentDidMount(){
        ACDCConverterService.getACDCConverterById(this.state.id).then( (res) =>{
            let aCDCConverter = res.data;
            this.setState({
            });
        });
    }

    updateACDCConverter = (e) => {
        e.preventDefault();
        let aCDCConverter = {
            aCDCConverterId: this.state.id,
        };
        console.log('aCDCConverter => ' + JSON.stringify(aCDCConverter));
        console.log('id => ' + JSON.stringify(this.state.id));
        ACDCConverterService.updateACDCConverter(aCDCConverter).then( res => {
            this.props.history.push('/aCDCConverters');
        });
    }


    cancel(){
        this.props.history.push('/aCDCConverters');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ACDCConverter</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateACDCConverter}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateACDCConverterComponent
