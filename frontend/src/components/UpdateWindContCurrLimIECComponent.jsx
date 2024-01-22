import React, { Component } from 'react'
import WindContCurrLimIECService from '../services/WindContCurrLimIECService';

class UpdateWindContCurrLimIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindContCurrLimIEC = this.updateWindContCurrLimIEC.bind(this);

    }

    componentDidMount(){
        WindContCurrLimIECService.getWindContCurrLimIECById(this.state.id).then( (res) =>{
            let windContCurrLimIEC = res.data;
            this.setState({
            });
        });
    }

    updateWindContCurrLimIEC = (e) => {
        e.preventDefault();
        let windContCurrLimIEC = {
            windContCurrLimIECId: this.state.id,
        };
        console.log('windContCurrLimIEC => ' + JSON.stringify(windContCurrLimIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindContCurrLimIECService.updateWindContCurrLimIEC(windContCurrLimIEC).then( res => {
            this.props.history.push('/windContCurrLimIECs');
        });
    }


    cancel(){
        this.props.history.push('/windContCurrLimIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindContCurrLimIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindContCurrLimIEC}>Save</button>
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

export default UpdateWindContCurrLimIECComponent
