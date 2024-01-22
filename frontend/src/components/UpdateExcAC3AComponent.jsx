import React, { Component } from 'react'
import ExcAC3AService from '../services/ExcAC3AService';

class UpdateExcAC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcAC3A = this.updateExcAC3A.bind(this);

    }

    componentDidMount(){
        ExcAC3AService.getExcAC3AById(this.state.id).then( (res) =>{
            let excAC3A = res.data;
            this.setState({
            });
        });
    }

    updateExcAC3A = (e) => {
        e.preventDefault();
        let excAC3A = {
            excAC3AId: this.state.id,
        };
        console.log('excAC3A => ' + JSON.stringify(excAC3A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAC3AService.updateExcAC3A(excAC3A).then( res => {
            this.props.history.push('/excAC3As');
        });
    }


    cancel(){
        this.props.history.push('/excAC3As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAC3A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAC3A}>Save</button>
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

export default UpdateExcAC3AComponent
