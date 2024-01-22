import React, { Component } from 'react'
import ExcAC1AService from '../services/ExcAC1AService';

class UpdateExcAC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcAC1A = this.updateExcAC1A.bind(this);

    }

    componentDidMount(){
        ExcAC1AService.getExcAC1AById(this.state.id).then( (res) =>{
            let excAC1A = res.data;
            this.setState({
            });
        });
    }

    updateExcAC1A = (e) => {
        e.preventDefault();
        let excAC1A = {
            excAC1AId: this.state.id,
        };
        console.log('excAC1A => ' + JSON.stringify(excAC1A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAC1AService.updateExcAC1A(excAC1A).then( res => {
            this.props.history.push('/excAC1As');
        });
    }


    cancel(){
        this.props.history.push('/excAC1As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAC1A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAC1A}>Save</button>
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

export default UpdateExcAC1AComponent
