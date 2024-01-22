import React, { Component } from 'react'
import ExcAC5AService from '../services/ExcAC5AService';

class UpdateExcAC5AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcAC5A = this.updateExcAC5A.bind(this);

    }

    componentDidMount(){
        ExcAC5AService.getExcAC5AById(this.state.id).then( (res) =>{
            let excAC5A = res.data;
            this.setState({
            });
        });
    }

    updateExcAC5A = (e) => {
        e.preventDefault();
        let excAC5A = {
            excAC5AId: this.state.id,
        };
        console.log('excAC5A => ' + JSON.stringify(excAC5A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAC5AService.updateExcAC5A(excAC5A).then( res => {
            this.props.history.push('/excAC5As');
        });
    }


    cancel(){
        this.props.history.push('/excAC5As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAC5A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAC5A}>Save</button>
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

export default UpdateExcAC5AComponent
