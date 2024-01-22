/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * ConnectivityNode business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of ConnectivityNode related services in the case of a
 *       ConnectivityNode business related service failing.
 *   <li>Exposes a simpler, uniform ConnectivityNode interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill ConnectivityNode business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class ConnectivityNodeBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public ConnectivityNodeBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * ConnectivityNode Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return ConnectivityNodeBusinessDelegate
   */
  public static ConnectivityNodeBusinessDelegate getConnectivityNodeInstance() {
    return (new ConnectivityNodeBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createConnectivityNode(CreateConnectivityNodeCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getConnectivityNodeId() == null) command.setConnectivityNodeId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateConnectivityNodeCommand - by convention the future return value for a
      // create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateConnectivityNodeCommand of ConnectivityNode is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create ConnectivityNode - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateConnectivityNodeCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateConnectivityNode(UpdateConnectivityNodeCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateConnectivityNodeCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save ConnectivityNode - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteConnectivityNodeCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteConnectivityNodeCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteConnectivityNodeCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete ConnectivityNode using Id = " + command.getConnectivityNodeId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the ConnectivityNode via ConnectivityNodeFetchOneSummary
   *
   * @param summary ConnectivityNodeFetchOneSummary
   * @return ConnectivityNodeFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public ConnectivityNode getConnectivityNode(ConnectivityNodeFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("ConnectivityNodeFetchOneSummary arg cannot be null");

    ConnectivityNode entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a ConnectivityNode
      // --------------------------------------
      CompletableFuture<ConnectivityNode> futureEntity =
          queryGateway.query(
              new FindConnectivityNodeQuery(
                  new LoadConnectivityNodeFilter(summary.getConnectivityNodeId())),
              ResponseTypes.instanceOf(ConnectivityNode.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate ConnectivityNode with id " + summary.getConnectivityNodeId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all ConnectivityNodes
   *
   * @return List<ConnectivityNode>
   * @exception ProcessingException Thrown if any problems
   */
  public List<ConnectivityNode> getAllConnectivityNode() throws ProcessingException {
    List<ConnectivityNode> list = null;

    try {
      CompletableFuture<List<ConnectivityNode>> futureList =
          queryGateway.query(
              new FindAllConnectivityNodeQuery(),
              ResponseTypes.multipleInstancesOf(ConnectivityNode.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all ConnectivityNode";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign BoundaryPoint on ConnectivityNode
   *
   * @param command AssignBoundaryPointToConnectivityNodeCommand
   * @exception ProcessingException
   */
  public void assignBoundaryPoint(AssignBoundaryPointToConnectivityNodeCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getConnectivityNodeId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    ConnectivityNodeBusinessDelegate parentDelegate =
        ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign BoundaryPoint on ConnectivityNode
   *
   * @param command UnAssignBoundaryPointFromConnectivityNodeCommand
   * @exception ProcessingException
   */
  public void unAssignBoundaryPoint(UnAssignBoundaryPointFromConnectivityNodeCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign BoundaryPoint on ConnectivityNode";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign FromEndIsoCode on ConnectivityNode
   *
   * @param command AssignFromEndIsoCodeToConnectivityNodeCommand
   * @exception ProcessingException
   */
  public void assignFromEndIsoCode(AssignFromEndIsoCodeToConnectivityNodeCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getConnectivityNodeId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    ConnectivityNodeBusinessDelegate parentDelegate =
        ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign FromEndIsoCode on ConnectivityNode
   *
   * @param command UnAssignFromEndIsoCodeFromConnectivityNodeCommand
   * @exception ProcessingException
   */
  public void unAssignFromEndIsoCode(UnAssignFromEndIsoCodeFromConnectivityNodeCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign FromEndIsoCode on ConnectivityNode";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign FromEndName on ConnectivityNode
   *
   * @param command AssignFromEndNameToConnectivityNodeCommand
   * @exception ProcessingException
   */
  public void assignFromEndName(AssignFromEndNameToConnectivityNodeCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getConnectivityNodeId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    ConnectivityNodeBusinessDelegate parentDelegate =
        ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign FromEndName on ConnectivityNode
   *
   * @param command UnAssignFromEndNameFromConnectivityNodeCommand
   * @exception ProcessingException
   */
  public void unAssignFromEndName(UnAssignFromEndNameFromConnectivityNodeCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign FromEndName on ConnectivityNode";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign FromEndNameTso on ConnectivityNode
   *
   * @param command AssignFromEndNameTsoToConnectivityNodeCommand
   * @exception ProcessingException
   */
  public void assignFromEndNameTso(AssignFromEndNameTsoToConnectivityNodeCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getConnectivityNodeId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    ConnectivityNodeBusinessDelegate parentDelegate =
        ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign FromEndNameTso on ConnectivityNode
   *
   * @param command UnAssignFromEndNameTsoFromConnectivityNodeCommand
   * @exception ProcessingException
   */
  public void unAssignFromEndNameTso(UnAssignFromEndNameTsoFromConnectivityNodeCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign FromEndNameTso on ConnectivityNode";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ToEndIsoCode on ConnectivityNode
   *
   * @param command AssignToEndIsoCodeToConnectivityNodeCommand
   * @exception ProcessingException
   */
  public void assignToEndIsoCode(AssignToEndIsoCodeToConnectivityNodeCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getConnectivityNodeId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    ConnectivityNodeBusinessDelegate parentDelegate =
        ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ToEndIsoCode on ConnectivityNode
   *
   * @param command UnAssignToEndIsoCodeFromConnectivityNodeCommand
   * @exception ProcessingException
   */
  public void unAssignToEndIsoCode(UnAssignToEndIsoCodeFromConnectivityNodeCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ToEndIsoCode on ConnectivityNode";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ToEndName on ConnectivityNode
   *
   * @param command AssignToEndNameToConnectivityNodeCommand
   * @exception ProcessingException
   */
  public void assignToEndName(AssignToEndNameToConnectivityNodeCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getConnectivityNodeId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    ConnectivityNodeBusinessDelegate parentDelegate =
        ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ToEndName on ConnectivityNode
   *
   * @param command UnAssignToEndNameFromConnectivityNodeCommand
   * @exception ProcessingException
   */
  public void unAssignToEndName(UnAssignToEndNameFromConnectivityNodeCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ToEndName on ConnectivityNode";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ToEndNameTso on ConnectivityNode
   *
   * @param command AssignToEndNameTsoToConnectivityNodeCommand
   * @exception ProcessingException
   */
  public void assignToEndNameTso(AssignToEndNameTsoToConnectivityNodeCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getConnectivityNodeId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    ConnectivityNodeBusinessDelegate parentDelegate =
        ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ToEndNameTso on ConnectivityNode
   *
   * @param command UnAssignToEndNameTsoFromConnectivityNodeCommand
   * @exception ProcessingException
   */
  public void unAssignToEndNameTso(UnAssignToEndNameTsoFromConnectivityNodeCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ToEndNameTso on ConnectivityNode";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * add ConnectivityNode to ConnectivityNodes
   *
   * @param command AssignConnectivityNodesToConnectivityNodeCommand
   * @exception ProcessingException
   */
  public void addToConnectivityNodes(AssignConnectivityNodesToConnectivityNodeCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getConnectivityNodeId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core
            .delegate.ConnectivityNodeBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile
                .core.delegate.ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance();
    ConnectivityNodeBusinessDelegate parentDelegate =
        ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance();
    UUID childId = command.getAddTo().getConnectivityNodeId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to add a ConnectivityNode as ConnectivityNodes to ConnectivityNode";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove ConnectivityNode from ConnectivityNodes
   *
   * @param command RemoveConnectivityNodesFromConnectivityNodeCommand
   * @exception ProcessingException
   */
  public void removeFromConnectivityNodes(
      RemoveConnectivityNodesFromConnectivityNodeCommand command) throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core
            .delegate.ConnectivityNodeBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile
                .core.delegate.ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance();
    UUID childId = command.getRemoveFrom().getConnectivityNodeId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      ConnectivityNodeValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Exception exc) {
      final String msg = "Failed to remove child using Id " + childId;
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return ConnectivityNode
   */
  private ConnectivityNode load(UUID id) throws ProcessingException {
    connectivityNode =
        ConnectivityNodeBusinessDelegate.getConnectivityNodeInstance()
            .getConnectivityNode(new ConnectivityNodeFetchOneSummary(id));
    return connectivityNode;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private ConnectivityNode connectivityNode = null;
  private static final Logger LOGGER =
      Logger.getLogger(ConnectivityNodeBusinessDelegate.class.getName());
}
