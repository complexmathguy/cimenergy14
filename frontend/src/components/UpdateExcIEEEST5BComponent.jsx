import React, { Component } from 'react'
import ExcIEEEST5BService from '../services/ExcIEEEST5BService';

class UpdateExcIEEEST5BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcIEEEST5B = this.updateExcIEEEST5B.bind(this);

    }

    componentDidMount(){
        ExcIEEEST5BService.getExcIEEEST5BById(this.state.id).then( (res) =>{
            let excIEEEST5B = res.data;
            this.setState({
            });
        });
    }

    updateExcIEEEST5B = (e) => {
        e.preventDefault();
        let excIEEEST5B = {
            excIEEEST5BId: this.state.id,
        };
        console.log('excIEEEST5B => ' + JSON.stringify(excIEEEST5B));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEST5BService.updateExcIEEEST5B(excIEEEST5B).then( res => {
            this.props.history.push('/excIEEEST5Bs');
        });
    }


    cancel(){
        this.props.history.push('/excIEEEST5Bs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEST5B</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEST5B}>Save</button>
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

export default UpdateExcIEEEST5BComponent
