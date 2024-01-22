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
package com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.topologyboundaryprofile.validator.*;
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
 * TopologyBoundaryVersion business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of TopologyBoundaryVersion related services in the case of a
 *       TopologyBoundaryVersion business related service failing.
 *   <li>Exposes a simpler, uniform TopologyBoundaryVersion interface to the business tier, making
 *       it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill TopologyBoundaryVersion
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class TopologyBoundaryVersionBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public TopologyBoundaryVersionBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * TopologyBoundaryVersion Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return TopologyBoundaryVersionBusinessDelegate
   */
  public static TopologyBoundaryVersionBusinessDelegate getTopologyBoundaryVersionInstance() {
    return (new TopologyBoundaryVersionBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createTopologyBoundaryVersion(
      CreateTopologyBoundaryVersionCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getTopologyBoundaryVersionId() == null)
        command.setTopologyBoundaryVersionId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateTopologyBoundaryVersionCommand - by convention the future return value for
      // a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateTopologyBoundaryVersionCommand of TopologyBoundaryVersion is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create TopologyBoundaryVersion - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateTopologyBoundaryVersionCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateTopologyBoundaryVersion(
      UpdateTopologyBoundaryVersionCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateTopologyBoundaryVersionCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save TopologyBoundaryVersion - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteTopologyBoundaryVersionCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteTopologyBoundaryVersionCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteTopologyBoundaryVersionCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete TopologyBoundaryVersion using Id = "
              + command.getTopologyBoundaryVersionId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the TopologyBoundaryVersion via TopologyBoundaryVersionFetchOneSummary
   *
   * @param summary TopologyBoundaryVersionFetchOneSummary
   * @return TopologyBoundaryVersionFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public TopologyBoundaryVersion getTopologyBoundaryVersion(
      TopologyBoundaryVersionFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "TopologyBoundaryVersionFetchOneSummary arg cannot be null");

    TopologyBoundaryVersion entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a TopologyBoundaryVersion
      // --------------------------------------
      CompletableFuture<TopologyBoundaryVersion> futureEntity =
          queryGateway.query(
              new FindTopologyBoundaryVersionQuery(
                  new LoadTopologyBoundaryVersionFilter(summary.getTopologyBoundaryVersionId())),
              ResponseTypes.instanceOf(TopologyBoundaryVersion.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate TopologyBoundaryVersion with id "
              + summary.getTopologyBoundaryVersionId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all TopologyBoundaryVersions
   *
   * @return List<TopologyBoundaryVersion>
   * @exception ProcessingException Thrown if any problems
   */
  public List<TopologyBoundaryVersion> getAllTopologyBoundaryVersion() throws ProcessingException {
    List<TopologyBoundaryVersion> list = null;

    try {
      CompletableFuture<List<TopologyBoundaryVersion>> futureList =
          queryGateway.query(
              new FindAllTopologyBoundaryVersionQuery(),
              ResponseTypes.multipleInstancesOf(TopologyBoundaryVersion.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all TopologyBoundaryVersion";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign BaseUML on TopologyBoundaryVersion
   *
   * @param command AssignBaseUMLToTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignBaseUML(AssignBaseUMLToTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologyBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    TopologyBoundaryVersionBusinessDelegate parentDelegate =
        TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

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
   * unAssign BaseUML on TopologyBoundaryVersion
   *
   * @param command UnAssignBaseUMLFromTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignBaseUML(UnAssignBaseUMLFromTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign BaseUML on TopologyBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign BaseURI on TopologyBoundaryVersion
   *
   * @param command AssignBaseURIToTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignBaseURI(AssignBaseURIToTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologyBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    TopologyBoundaryVersionBusinessDelegate parentDelegate =
        TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

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
   * unAssign BaseURI on TopologyBoundaryVersion
   *
   * @param command UnAssignBaseURIFromTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignBaseURI(UnAssignBaseURIFromTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign BaseURI on TopologyBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Date on TopologyBoundaryVersion
   *
   * @param command AssignDateToTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignDate(AssignDateToTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologyBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .DateProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .DateProxyBusinessDelegate.getDateProxyInstance();
    TopologyBoundaryVersionBusinessDelegate parentDelegate =
        TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance();
    UUID childId = command.getAssignment().getDateProxyId();
    DateProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get DateProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Date on TopologyBoundaryVersion
   *
   * @param command UnAssignDateFromTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignDate(UnAssignDateFromTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Date on TopologyBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign DifferenceModelURI on TopologyBoundaryVersion
   *
   * @param command AssignDifferenceModelURIToTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignDifferenceModelURI(
      AssignDifferenceModelURIToTopologyBoundaryVersionCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologyBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    TopologyBoundaryVersionBusinessDelegate parentDelegate =
        TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

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
   * unAssign DifferenceModelURI on TopologyBoundaryVersion
   *
   * @param command UnAssignDifferenceModelURIFromTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignDifferenceModelURI(
      UnAssignDifferenceModelURIFromTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign DifferenceModelURI on TopologyBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign EntsoeUML on TopologyBoundaryVersion
   *
   * @param command AssignEntsoeUMLToTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignEntsoeUML(AssignEntsoeUMLToTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologyBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    TopologyBoundaryVersionBusinessDelegate parentDelegate =
        TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

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
   * unAssign EntsoeUML on TopologyBoundaryVersion
   *
   * @param command UnAssignEntsoeUMLFromTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignEntsoeUML(UnAssignEntsoeUMLFromTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign EntsoeUML on TopologyBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign EntsoeURI on TopologyBoundaryVersion
   *
   * @param command AssignEntsoeURIToTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignEntsoeURI(AssignEntsoeURIToTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologyBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    TopologyBoundaryVersionBusinessDelegate parentDelegate =
        TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

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
   * unAssign EntsoeURI on TopologyBoundaryVersion
   *
   * @param command UnAssignEntsoeURIFromTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignEntsoeURI(UnAssignEntsoeURIFromTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign EntsoeURI on TopologyBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ModelDescriptionURI on TopologyBoundaryVersion
   *
   * @param command AssignModelDescriptionURIToTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignModelDescriptionURI(
      AssignModelDescriptionURIToTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologyBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    TopologyBoundaryVersionBusinessDelegate parentDelegate =
        TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

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
   * unAssign ModelDescriptionURI on TopologyBoundaryVersion
   *
   * @param command UnAssignModelDescriptionURIFromTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignModelDescriptionURI(
      UnAssignModelDescriptionURIFromTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ModelDescriptionURI on TopologyBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NamespaceRDF on TopologyBoundaryVersion
   *
   * @param command AssignNamespaceRDFToTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignNamespaceRDF(AssignNamespaceRDFToTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologyBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    TopologyBoundaryVersionBusinessDelegate parentDelegate =
        TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

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
   * unAssign NamespaceRDF on TopologyBoundaryVersion
   *
   * @param command UnAssignNamespaceRDFFromTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignNamespaceRDF(UnAssignNamespaceRDFFromTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NamespaceRDF on TopologyBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NamespaceUML on TopologyBoundaryVersion
   *
   * @param command AssignNamespaceUMLToTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignNamespaceUML(AssignNamespaceUMLToTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologyBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    TopologyBoundaryVersionBusinessDelegate parentDelegate =
        TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

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
   * unAssign NamespaceUML on TopologyBoundaryVersion
   *
   * @param command UnAssignNamespaceUMLFromTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignNamespaceUML(UnAssignNamespaceUMLFromTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NamespaceUML on TopologyBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ShortName on TopologyBoundaryVersion
   *
   * @param command AssignShortNameToTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignShortName(AssignShortNameToTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getTopologyBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    TopologyBoundaryVersionBusinessDelegate parentDelegate =
        TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

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
   * unAssign ShortName on TopologyBoundaryVersion
   *
   * @param command UnAssignShortNameFromTopologyBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignShortName(UnAssignShortNameFromTopologyBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      TopologyBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ShortName on TopologyBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return TopologyBoundaryVersion
   */
  private TopologyBoundaryVersion load(UUID id) throws ProcessingException {
    topologyBoundaryVersion =
        TopologyBoundaryVersionBusinessDelegate.getTopologyBoundaryVersionInstance()
            .getTopologyBoundaryVersion(new TopologyBoundaryVersionFetchOneSummary(id));
    return topologyBoundaryVersion;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private TopologyBoundaryVersion topologyBoundaryVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(TopologyBoundaryVersionBusinessDelegate.class.getName());
}
