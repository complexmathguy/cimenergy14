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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.validator.*;
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
 * SvPowerFlow business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of SvPowerFlow related services in the case of a SvPowerFlow
 *       business related service failing.
 *   <li>Exposes a simpler, uniform SvPowerFlow interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill SvPowerFlow business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class SvPowerFlowBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public SvPowerFlowBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * SvPowerFlow Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return SvPowerFlowBusinessDelegate
   */
  public static SvPowerFlowBusinessDelegate getSvPowerFlowInstance() {
    return (new SvPowerFlowBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createSvPowerFlow(CreateSvPowerFlowCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getSvPowerFlowId() == null) command.setSvPowerFlowId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      SvPowerFlowValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateSvPowerFlowCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateSvPowerFlowCommand of SvPowerFlow is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create SvPowerFlow - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateSvPowerFlowCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateSvPowerFlow(UpdateSvPowerFlowCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      SvPowerFlowValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateSvPowerFlowCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save SvPowerFlow - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteSvPowerFlowCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteSvPowerFlowCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SvPowerFlowValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteSvPowerFlowCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete SvPowerFlow using Id = " + command.getSvPowerFlowId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the SvPowerFlow via SvPowerFlowFetchOneSummary
   *
   * @param summary SvPowerFlowFetchOneSummary
   * @return SvPowerFlowFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public SvPowerFlow getSvPowerFlow(SvPowerFlowFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("SvPowerFlowFetchOneSummary arg cannot be null");

    SvPowerFlow entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      SvPowerFlowValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a SvPowerFlow
      // --------------------------------------
      CompletableFuture<SvPowerFlow> futureEntity =
          queryGateway.query(
              new FindSvPowerFlowQuery(new LoadSvPowerFlowFilter(summary.getSvPowerFlowId())),
              ResponseTypes.instanceOf(SvPowerFlow.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate SvPowerFlow with id " + summary.getSvPowerFlowId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all SvPowerFlows
   *
   * @return List<SvPowerFlow>
   * @exception ProcessingException Thrown if any problems
   */
  public List<SvPowerFlow> getAllSvPowerFlow() throws ProcessingException {
    List<SvPowerFlow> list = null;

    try {
      CompletableFuture<List<SvPowerFlow>> futureList =
          queryGateway.query(
              new FindAllSvPowerFlowQuery(), ResponseTypes.multipleInstancesOf(SvPowerFlow.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all SvPowerFlow";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign P on SvPowerFlow
   *
   * @param command AssignPToSvPowerFlowCommand
   * @exception ProcessingException
   */
  public void assignP(AssignPToSvPowerFlowCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSvPowerFlowId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ActivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ActivePowerBusinessDelegate.getActivePowerInstance();
    SvPowerFlowBusinessDelegate parentDelegate =
        SvPowerFlowBusinessDelegate.getSvPowerFlowInstance();
    UUID childId = command.getAssignment().getActivePowerId();
    ActivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SvPowerFlowValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ActivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign P on SvPowerFlow
   *
   * @param command UnAssignPFromSvPowerFlowCommand
   * @exception ProcessingException
   */
  public void unAssignP(UnAssignPFromSvPowerFlowCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SvPowerFlowValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign P on SvPowerFlow";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Q on SvPowerFlow
   *
   * @param command AssignQToSvPowerFlowCommand
   * @exception ProcessingException
   */
  public void assignQ(AssignQToSvPowerFlowCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSvPowerFlowId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .ReactivePowerBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .ReactivePowerBusinessDelegate.getReactivePowerInstance();
    SvPowerFlowBusinessDelegate parentDelegate =
        SvPowerFlowBusinessDelegate.getSvPowerFlowInstance();
    UUID childId = command.getAssignment().getReactivePowerId();
    ReactivePower child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SvPowerFlowValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get ReactivePower using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Q on SvPowerFlow
   *
   * @param command UnAssignQFromSvPowerFlowCommand
   * @exception ProcessingException
   */
  public void unAssignQ(UnAssignQFromSvPowerFlowCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SvPowerFlowValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Q on SvPowerFlow";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign SvPowerFlow on SvPowerFlow
   *
   * @param command AssignSvPowerFlowToSvPowerFlowCommand
   * @exception ProcessingException
   */
  public void assignSvPowerFlow(AssignSvPowerFlowToSvPowerFlowCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getSvPowerFlowId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile
            .statevariables.delegate.SvPowerFlowBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile
                .statevariables.delegate.SvPowerFlowBusinessDelegate.getSvPowerFlowInstance();
    SvPowerFlowBusinessDelegate parentDelegate =
        SvPowerFlowBusinessDelegate.getSvPowerFlowInstance();
    UUID childId = command.getAssignment().getSvPowerFlowId();
    SvPowerFlow child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      SvPowerFlowValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get SvPowerFlow using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign SvPowerFlow on SvPowerFlow
   *
   * @param command UnAssignSvPowerFlowFromSvPowerFlowCommand
   * @exception ProcessingException
   */
  public void unAssignSvPowerFlow(UnAssignSvPowerFlowFromSvPowerFlowCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      SvPowerFlowValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign SvPowerFlow on SvPowerFlow";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return SvPowerFlow
   */
  private SvPowerFlow load(UUID id) throws ProcessingException {
    svPowerFlow =
        SvPowerFlowBusinessDelegate.getSvPowerFlowInstance()
            .getSvPowerFlow(new SvPowerFlowFetchOneSummary(id));
    return svPowerFlow;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private SvPowerFlow svPowerFlow = null;
  private static final Logger LOGGER =
      Logger.getLogger(SvPowerFlowBusinessDelegate.class.getName());
}
