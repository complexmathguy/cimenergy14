import React, { Component } from 'react'
import ExcIEEEST6BService from '../services/ExcIEEEST6BService';

class UpdateExcIEEEST6BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                oelin: ''
        }
        this.updateExcIEEEST6B = this.updateExcIEEEST6B.bind(this);

        this.changeOelinHandler = this.changeOelinHandler.bind(this);
    }

    componentDidMount(){
        ExcIEEEST6BService.getExcIEEEST6BById(this.state.id).then( (res) =>{
            let excIEEEST6B = res.data;
            this.setState({
                oelin: excIEEEST6B.oelin
            });
        });
    }

    updateExcIEEEST6B = (e) => {
        e.preventDefault();
        let excIEEEST6B = {
            excIEEEST6BId: this.state.id,
            oelin: this.state.oelin
        };
        console.log('excIEEEST6B => ' + JSON.stringify(excIEEEST6B));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEST6BService.updateExcIEEEST6B(excIEEEST6B).then( res => {
            this.props.history.push('/excIEEEST6Bs');
        });
    }

    changeOelinHandler= (event) => {
        this.setState({oelin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excIEEEST6Bs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEST6B</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Oelin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEST6B}>Save</button>
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

export default UpdateExcIEEEST6BComponent
