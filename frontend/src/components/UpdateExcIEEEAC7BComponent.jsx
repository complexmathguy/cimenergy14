import React, { Component } from 'react'
import ExcIEEEAC7BService from '../services/ExcIEEEAC7BService';

class UpdateExcIEEEAC7BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcIEEEAC7B = this.updateExcIEEEAC7B.bind(this);

    }

    componentDidMount(){
        ExcIEEEAC7BService.getExcIEEEAC7BById(this.state.id).then( (res) =>{
            let excIEEEAC7B = res.data;
            this.setState({
            });
        });
    }

    updateExcIEEEAC7B = (e) => {
        e.preventDefault();
        let excIEEEAC7B = {
            excIEEEAC7BId: this.state.id,
        };
        console.log('excIEEEAC7B => ' + JSON.stringify(excIEEEAC7B));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEAC7BService.updateExcIEEEAC7B(excIEEEAC7B).then( res => {
            this.props.history.push('/excIEEEAC7Bs');
        });
    }


    cancel(){
        this.props.history.push('/excIEEEAC7Bs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEAC7B</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEAC7B}>Save</button>
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

export default UpdateExcIEEEAC7BComponent
