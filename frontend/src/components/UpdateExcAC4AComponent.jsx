import React, { Component } from 'react'
import ExcAC4AService from '../services/ExcAC4AService';

class UpdateExcAC4AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcAC4A = this.updateExcAC4A.bind(this);

    }

    componentDidMount(){
        ExcAC4AService.getExcAC4AById(this.state.id).then( (res) =>{
            let excAC4A = res.data;
            this.setState({
            });
        });
    }

    updateExcAC4A = (e) => {
        e.preventDefault();
        let excAC4A = {
            excAC4AId: this.state.id,
        };
        console.log('excAC4A => ' + JSON.stringify(excAC4A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAC4AService.updateExcAC4A(excAC4A).then( res => {
            this.props.history.push('/excAC4As');
        });
    }


    cancel(){
        this.props.history.push('/excAC4As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAC4A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAC4A}>Save</button>
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

export default UpdateExcAC4AComponent
