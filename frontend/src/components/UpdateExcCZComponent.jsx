import React, { Component } from 'react'
import ExcCZService from '../services/ExcCZService';

class UpdateExcCZComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcCZ = this.updateExcCZ.bind(this);

    }

    componentDidMount(){
        ExcCZService.getExcCZById(this.state.id).then( (res) =>{
            let excCZ = res.data;
            this.setState({
            });
        });
    }

    updateExcCZ = (e) => {
        e.preventDefault();
        let excCZ = {
            excCZId: this.state.id,
        };
        console.log('excCZ => ' + JSON.stringify(excCZ));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcCZService.updateExcCZ(excCZ).then( res => {
            this.props.history.push('/excCZs');
        });
    }


    cancel(){
        this.props.history.push('/excCZs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcCZ</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcCZ}>Save</button>
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

export default UpdateExcCZComponent
