import React, { Component } from 'react'
import ExcIEEEAC8BService from '../services/ExcIEEEAC8BService';

class UpdateExcIEEEAC8BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcIEEEAC8B = this.updateExcIEEEAC8B.bind(this);

    }

    componentDidMount(){
        ExcIEEEAC8BService.getExcIEEEAC8BById(this.state.id).then( (res) =>{
            let excIEEEAC8B = res.data;
            this.setState({
            });
        });
    }

    updateExcIEEEAC8B = (e) => {
        e.preventDefault();
        let excIEEEAC8B = {
            excIEEEAC8BId: this.state.id,
        };
        console.log('excIEEEAC8B => ' + JSON.stringify(excIEEEAC8B));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEAC8BService.updateExcIEEEAC8B(excIEEEAC8B).then( res => {
            this.props.history.push('/excIEEEAC8Bs');
        });
    }


    cancel(){
        this.props.history.push('/excIEEEAC8Bs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEAC8B</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEAC8B}>Save</button>
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

export default UpdateExcIEEEAC8BComponent
