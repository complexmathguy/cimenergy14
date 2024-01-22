import React, { Component } from 'react'
import ExcIEEEST4BService from '../services/ExcIEEEST4BService';

class UpdateExcIEEEST4BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcIEEEST4B = this.updateExcIEEEST4B.bind(this);

    }

    componentDidMount(){
        ExcIEEEST4BService.getExcIEEEST4BById(this.state.id).then( (res) =>{
            let excIEEEST4B = res.data;
            this.setState({
            });
        });
    }

    updateExcIEEEST4B = (e) => {
        e.preventDefault();
        let excIEEEST4B = {
            excIEEEST4BId: this.state.id,
        };
        console.log('excIEEEST4B => ' + JSON.stringify(excIEEEST4B));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEST4BService.updateExcIEEEST4B(excIEEEST4B).then( res => {
            this.props.history.push('/excIEEEST4Bs');
        });
    }


    cancel(){
        this.props.history.push('/excIEEEST4Bs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEST4B</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEST4B}>Save</button>
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

export default UpdateExcIEEEST4BComponent
