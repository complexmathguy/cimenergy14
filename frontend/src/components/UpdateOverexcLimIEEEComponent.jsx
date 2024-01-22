import React, { Component } from 'react'
import OverexcLimIEEEService from '../services/OverexcLimIEEEService';

class UpdateOverexcLimIEEEComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateOverexcLimIEEE = this.updateOverexcLimIEEE.bind(this);

    }

    componentDidMount(){
        OverexcLimIEEEService.getOverexcLimIEEEById(this.state.id).then( (res) =>{
            let overexcLimIEEE = res.data;
            this.setState({
            });
        });
    }

    updateOverexcLimIEEE = (e) => {
        e.preventDefault();
        let overexcLimIEEE = {
            overexcLimIEEEId: this.state.id,
        };
        console.log('overexcLimIEEE => ' + JSON.stringify(overexcLimIEEE));
        console.log('id => ' + JSON.stringify(this.state.id));
        OverexcLimIEEEService.updateOverexcLimIEEE(overexcLimIEEE).then( res => {
            this.props.history.push('/overexcLimIEEEs');
        });
    }


    cancel(){
        this.props.history.push('/overexcLimIEEEs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update OverexcLimIEEE</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateOverexcLimIEEE}>Save</button>
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

export default UpdateOverexcLimIEEEComponent
