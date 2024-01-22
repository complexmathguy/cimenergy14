import React, { Component } from 'react'
import ExcOEX3TService from '../services/ExcOEX3TService';

class UpdateExcOEX3TComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcOEX3T = this.updateExcOEX3T.bind(this);

    }

    componentDidMount(){
        ExcOEX3TService.getExcOEX3TById(this.state.id).then( (res) =>{
            let excOEX3T = res.data;
            this.setState({
            });
        });
    }

    updateExcOEX3T = (e) => {
        e.preventDefault();
        let excOEX3T = {
            excOEX3TId: this.state.id,
        };
        console.log('excOEX3T => ' + JSON.stringify(excOEX3T));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcOEX3TService.updateExcOEX3T(excOEX3T).then( res => {
            this.props.history.push('/excOEX3Ts');
        });
    }


    cancel(){
        this.props.history.push('/excOEX3Ts');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcOEX3T</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcOEX3T}>Save</button>
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

export default UpdateExcOEX3TComponent
