import React, { Component } from 'react'
import ExcBBCService from '../services/ExcBBCService';

class UpdateExcBBCComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcBBC = this.updateExcBBC.bind(this);

    }

    componentDidMount(){
        ExcBBCService.getExcBBCById(this.state.id).then( (res) =>{
            let excBBC = res.data;
            this.setState({
            });
        });
    }

    updateExcBBC = (e) => {
        e.preventDefault();
        let excBBC = {
            excBBCId: this.state.id,
        };
        console.log('excBBC => ' + JSON.stringify(excBBC));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcBBCService.updateExcBBC(excBBC).then( res => {
            this.props.history.push('/excBBCs');
        });
    }


    cancel(){
        this.props.history.push('/excBBCs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcBBC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcBBC}>Save</button>
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

export default UpdateExcBBCComponent
