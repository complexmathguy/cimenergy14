import React, { Component } from 'react'
import ExcHUService from '../services/ExcHUService';

class UpdateExcHUComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcHU = this.updateExcHU.bind(this);

    }

    componentDidMount(){
        ExcHUService.getExcHUById(this.state.id).then( (res) =>{
            let excHU = res.data;
            this.setState({
            });
        });
    }

    updateExcHU = (e) => {
        e.preventDefault();
        let excHU = {
            excHUId: this.state.id,
        };
        console.log('excHU => ' + JSON.stringify(excHU));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcHUService.updateExcHU(excHU).then( res => {
            this.props.history.push('/excHUs');
        });
    }


    cancel(){
        this.props.history.push('/excHUs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcHU</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcHU}>Save</button>
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

export default UpdateExcHUComponent
