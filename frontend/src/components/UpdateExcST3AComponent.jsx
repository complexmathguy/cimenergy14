import React, { Component } from 'react'
import ExcST3AService from '../services/ExcST3AService';

class UpdateExcST3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcST3A = this.updateExcST3A.bind(this);

    }

    componentDidMount(){
        ExcST3AService.getExcST3AById(this.state.id).then( (res) =>{
            let excST3A = res.data;
            this.setState({
            });
        });
    }

    updateExcST3A = (e) => {
        e.preventDefault();
        let excST3A = {
            excST3AId: this.state.id,
        };
        console.log('excST3A => ' + JSON.stringify(excST3A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcST3AService.updateExcST3A(excST3A).then( res => {
            this.props.history.push('/excST3As');
        });
    }


    cancel(){
        this.props.history.push('/excST3As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcST3A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcST3A}>Save</button>
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

export default UpdateExcST3AComponent
