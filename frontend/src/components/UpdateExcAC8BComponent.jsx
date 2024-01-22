import React, { Component } from 'react'
import ExcAC8BService from '../services/ExcAC8BService';

class UpdateExcAC8BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcAC8B = this.updateExcAC8B.bind(this);

    }

    componentDidMount(){
        ExcAC8BService.getExcAC8BById(this.state.id).then( (res) =>{
            let excAC8B = res.data;
            this.setState({
            });
        });
    }

    updateExcAC8B = (e) => {
        e.preventDefault();
        let excAC8B = {
            excAC8BId: this.state.id,
        };
        console.log('excAC8B => ' + JSON.stringify(excAC8B));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAC8BService.updateExcAC8B(excAC8B).then( res => {
            this.props.history.push('/excAC8Bs');
        });
    }


    cancel(){
        this.props.history.push('/excAC8Bs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAC8B</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAC8B}>Save</button>
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

export default UpdateExcAC8BComponent
