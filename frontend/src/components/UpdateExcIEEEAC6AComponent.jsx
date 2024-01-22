import React, { Component } from 'react'
import ExcIEEEAC6AService from '../services/ExcIEEEAC6AService';

class UpdateExcIEEEAC6AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcIEEEAC6A = this.updateExcIEEEAC6A.bind(this);

    }

    componentDidMount(){
        ExcIEEEAC6AService.getExcIEEEAC6AById(this.state.id).then( (res) =>{
            let excIEEEAC6A = res.data;
            this.setState({
            });
        });
    }

    updateExcIEEEAC6A = (e) => {
        e.preventDefault();
        let excIEEEAC6A = {
            excIEEEAC6AId: this.state.id,
        };
        console.log('excIEEEAC6A => ' + JSON.stringify(excIEEEAC6A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEAC6AService.updateExcIEEEAC6A(excIEEEAC6A).then( res => {
            this.props.history.push('/excIEEEAC6As');
        });
    }


    cancel(){
        this.props.history.push('/excIEEEAC6As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEAC6A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEAC6A}>Save</button>
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

export default UpdateExcIEEEAC6AComponent
