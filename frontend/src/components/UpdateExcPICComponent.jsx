import React, { Component } from 'react'
import ExcPICService from '../services/ExcPICService';

class UpdateExcPICComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcPIC = this.updateExcPIC.bind(this);

    }

    componentDidMount(){
        ExcPICService.getExcPICById(this.state.id).then( (res) =>{
            let excPIC = res.data;
            this.setState({
            });
        });
    }

    updateExcPIC = (e) => {
        e.preventDefault();
        let excPIC = {
            excPICId: this.state.id,
        };
        console.log('excPIC => ' + JSON.stringify(excPIC));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcPICService.updateExcPIC(excPIC).then( res => {
            this.props.history.push('/excPICs');
        });
    }


    cancel(){
        this.props.history.push('/excPICs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcPIC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcPIC}>Save</button>
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

export default UpdateExcPICComponent
