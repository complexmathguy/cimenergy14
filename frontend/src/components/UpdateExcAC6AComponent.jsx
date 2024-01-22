import React, { Component } from 'react'
import ExcAC6AService from '../services/ExcAC6AService';

class UpdateExcAC6AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcAC6A = this.updateExcAC6A.bind(this);

    }

    componentDidMount(){
        ExcAC6AService.getExcAC6AById(this.state.id).then( (res) =>{
            let excAC6A = res.data;
            this.setState({
            });
        });
    }

    updateExcAC6A = (e) => {
        e.preventDefault();
        let excAC6A = {
            excAC6AId: this.state.id,
        };
        console.log('excAC6A => ' + JSON.stringify(excAC6A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAC6AService.updateExcAC6A(excAC6A).then( res => {
            this.props.history.push('/excAC6As');
        });
    }


    cancel(){
        this.props.history.push('/excAC6As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAC6A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAC6A}>Save</button>
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

export default UpdateExcAC6AComponent
