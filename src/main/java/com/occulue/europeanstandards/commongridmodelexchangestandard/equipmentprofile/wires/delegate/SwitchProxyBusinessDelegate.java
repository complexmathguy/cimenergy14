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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.validator.*;
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
 * SwitchProxy business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of SwitchProxy related services in the case of a SwitchProxy
 *       business related service failing.
 *   <li>Exposes a simpler, uniform SwitchProxy interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill SwitchProxy business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class SwitchProxyBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public SwitchProxyBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * SwitchProxy Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return SwitchProxyBusinessDelegate
   */
  public static SwitchProxyBusinessDelegate getSwitchProxyInstance() {
    return (new SwitchProxyBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createSwitchProxy(CreateSwitchProxyCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getSwitchProxyId() == null) command.setSwitchProxyId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SwitchProxyValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateSwitchProxyCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateSwitchProxyCommand of SwitchProxy is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create SwitchProxy - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateSwitchProxyCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateSwitchProxy(UpdateSwitchProxyCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      SwitchProxyValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateSwitchProxyCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save SwitchProxy - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteSwitchProxyCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteSwitchProxyCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SwitchProxyValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteSwitchProxyCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete SwitchProxy using Id = " + command.getSwitchProxyId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the SwitchProxy via SwitchProxyFetchOneSummary
   *
   * @param summary SwitchProxyFetchOneSummary
   * @return SwitchProxyFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public SwitchProxy getSwitchProxy(SwitchProxyFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("SwitchProxyFetchOneSummary arg cannot be null");

    SwitchProxy entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      SwitchProxyValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a SwitchProxy
      // --------------------------------------
      CompletableFuture<SwitchProxy> futureEntity =
          queryGateway.query(
              new FindSwitchProxyQuery(new LoadSwitchProxyFilter(summary.getSwitchProxyId())),
              ResponseTypes.instanceOf(SwitchProxy.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate SwitchProxy with id " + summary.getSwitchProxyId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all SwitchProxys
   *
   * @return List<SwitchProxy>
   * @exception ProcessingException Thrown if any problems
   */
  public List<SwitchProxy> getAllSwitchProxy() throws ProcessingException {
    List<SwitchProxy> list = null;

    try {
      CompletableFuture<List<SwitchProxy>> futureList =
          queryGateway.query(
              new FindAllSwitchProxyQuery(), ResponseTypes.multipleInstancesOf(SwitchProxy.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all SwitchProxy";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign NormalOpen on SwitchProxy
   *
   * @param command AssignNormalOpenToSwitchProxyCommand
   * @exception ProcessingException
   */
  public void assignNormalOpen(AssignNormalOpenToSwitchProxyCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSwitchProxyId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    SwitchProxyBusinessDelegate parentDelegate =
        SwitchProxyBusinessDelegate.getSwitchProxyInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SwitchProxyValidator.getInstance().validate(command);

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
   * unAssign NormalOpen on SwitchProxy
   *
   * @param command UnAssignNormalOpenFromSwitchProxyCommand
   * @exception ProcessingException
   */
  public void unAssignNormalOpen(UnAssignNormalOpenFromSwitchProxyCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SwitchProxyValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NormalOpen on SwitchProxy";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign RatedCurrent on SwitchProxy
   *
   * @param command AssignRatedCurrentToSwitchProxyCommand
   * @exception ProcessingException
   */
  public void assignRatedCurrent(AssignRatedCurrentToSwitchProxyCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSwitchProxyId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .CurrentFlowBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .CurrentFlowBusinessDelegate.getCurrentFlowInstance();
    SwitchProxyBusinessDelegate parentDelegate =
        SwitchProxyBusinessDelegate.getSwitchProxyInstance();
    UUID childId = command.getAssignment().getCurrentFlowId();
    CurrentFlow child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SwitchProxyValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get CurrentFlow using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign RatedCurrent on SwitchProxy
   *
   * @param command UnAssignRatedCurrentFromSwitchProxyCommand
   * @exception ProcessingException
   */
  public void unAssignRatedCurrent(UnAssignRatedCurrentFromSwitchProxyCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SwitchProxyValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign RatedCurrent on SwitchProxy";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Retained on SwitchProxy
   *
   * @param command AssignRetainedToSwitchProxyCommand
   * @exception ProcessingException
   */
  public void assignRetained(AssignRetainedToSwitchProxyCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSwitchProxyId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    SwitchProxyBusinessDelegate parentDelegate =
        SwitchProxyBusinessDelegate.getSwitchProxyInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SwitchProxyValidator.getInstance().validate(command);

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
   * unAssign Retained on SwitchProxy
   *
   * @param command UnAssignRetainedFromSwitchProxyCommand
   * @exception ProcessingException
   */
  public void unAssignRetained(UnAssignRetainedFromSwitchProxyCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SwitchProxyValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Retained on SwitchProxy";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return SwitchProxy
   */
  private SwitchProxy load(UUID id) throws ProcessingException {
    switchProxy =
        SwitchProxyBusinessDelegate.getSwitchProxyInstance()
            .getSwitchProxy(new SwitchProxyFetchOneSummary(id));
    return switchProxy;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private SwitchProxy switchProxy = null;
  private static final Logger LOGGER =
      Logger.getLogger(SwitchProxyBusinessDelegate.class.getName());
}
